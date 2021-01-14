package com.example.themeleaf.service.impl;

import com.example.themeleaf.service.BlockTranInfo;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequenceGenerator;
import org.bouncycastle.util.encoders.UTF8;
import org.hyperledger.fabric.protos.ledger.rwset.kvrwset.KvRwset;
import org.hyperledger.fabric.sdk.BlockInfo;
import org.hyperledger.fabric.sdk.TxReadWriteSetInfo;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockTranInfoImpl {

    /**
     * <code>VALID = 0;</code>
     */
    public static final int VALID_VALUE = 0;
    /**
     * <code>NIL_ENVELOPE = 1;</code>
     */
    public static final int NIL_ENVELOPE_VALUE = 1;
    /**
     * <code>BAD_PAYLOAD = 2;</code>
     */
    public static final int BAD_PAYLOAD_VALUE = 2;
    /**
     * <code>BAD_COMMON_HEADER = 3;</code>
     */
    public static final int BAD_COMMON_HEADER_VALUE = 3;
    /**
     * <code>BAD_CREATOR_SIGNATURE = 4;</code>
     */
    public static final int BAD_CREATOR_SIGNATURE_VALUE = 4;
    /**
     * <code>INVALID_ENDORSER_TRANSACTION = 5;</code>
     */
    public static final int INVALID_ENDORSER_TRANSACTION_VALUE = 5;
    /**
     * <code>INVALID_CONFIG_TRANSACTION = 6;</code>
     */
    public static final int INVALID_CONFIG_TRANSACTION_VALUE = 6;
    /**
     * <code>UNSUPPORTED_TX_PAYLOAD = 7;</code>
     */
    public static final int UNSUPPORTED_TX_PAYLOAD_VALUE = 7;
    /**
     * <code>BAD_PROPOSAL_TXID = 8;</code>
     */
    public static final int BAD_PROPOSAL_TXID_VALUE = 8;
    /**
     * <code>DUPLICATE_TXID = 9;</code>
     */
    public static final int DUPLICATE_TXID_VALUE = 9;
    /**
     * <code>ENDORSEMENT_POLICY_FAILURE = 10;</code>
     */
    public static final int ENDORSEMENT_POLICY_FAILURE_VALUE = 10;
    /**
     * <code>MVCC_READ_CONFLICT = 11;</code>
     */
    public static final int MVCC_READ_CONFLICT_VALUE = 11;
    /**
     * <code>PHANTOM_READ_CONFLICT = 12;</code>
     */
    public static final int PHANTOM_READ_CONFLICT_VALUE = 12;
    /**
     * <code>UNKNOWN_TX_TYPE = 13;</code>
     */
    public static final int UNKNOWN_TX_TYPE_VALUE = 13;
    /**
     * <code>TARGET_CHAIN_NOT_FOUND = 14;</code>
     */
    public static final int TARGET_CHAIN_NOT_FOUND_VALUE = 14;
    /**
     * <code>MARSHAL_TX_ERROR = 15;</code>
     */
    public static final int MARSHAL_TX_ERROR_VALUE = 15;
    /**
     * <code>NIL_TXACTION = 16;</code>
     */
    public static final int NIL_TXACTION_VALUE = 16;
    /**
     * <code>EXPIRED_CHAINCODE = 17;</code>
     */
    public static final int EXPIRED_CHAINCODE_VALUE = 17;
    /**
     * <code>CHAINCODE_VERSION_CONFLICT = 18;</code>
     */
    public static final int CHAINCODE_VERSION_CONFLICT_VALUE = 18;
    /**
     * <code>BAD_HEADER_EXTENSION = 19;</code>
     */
    public static final int BAD_HEADER_EXTENSION_VALUE = 19;
    /**
     * <code>BAD_CHANNEL_HEADER = 20;</code>
     */
    public static final int BAD_CHANNEL_HEADER_VALUE = 20;
    /**
     * <code>BAD_RESPONSE_PAYLOAD = 21;</code>
     */
    public static final int BAD_RESPONSE_PAYLOAD_VALUE = 21;
    /**
     * <code>BAD_RWSET = 22;</code>
     */
    public static final int BAD_RWSET_VALUE = 22;
    /**
     * <code>ILLEGAL_WRITESET = 23;</code>
     */
    public static final int ILLEGAL_WRITESET_VALUE = 23;
    /**
     * <code>INVALID_WRITESET = 24;</code>
     */
    public static final int INVALID_WRITESET_VALUE = 24;
    /**
     * <code>NOT_VALIDATED = 254;</code>
     */
    public static final int NOT_VALIDATED_VALUE = 254;
    /**
     * <code>INVALID_OTHER_REASON = 255;</code>
     */
    public static final int INVALID_OTHER_REASON_VALUE = 255;

    public static String[] transactionValidCode=new String[]
            {"VALID","NIL_ENVELOPE_VALUE","BAD_PAYLOAD_VALUE","BAD_COMMON_HEADER_VALUE",
                    "BAD_CREATOR_SIGNATURE_VALUE","INVALID_ENDORSER_TRANSACTION_VALUE","INVALID_CONFIG_TRANSACTION_VALUE","UNSUPPORTED_TX_PAYLOAD_VALUE",
                    "BAD_PROPOSAL_TXID_VALUE","DUPLICATE_TXID_VALUE","ENDORSEMENT_POLICY_FAILURE_VALUE","MVCC_READ_CONFLICT_VALUE",
                    "PHANTOM_READ_CONFLICT_VALUE","UNKNOWN_TX_TYPE_VALUE","TARGET_CHAIN_NOT_FOUND_VALUE","MARSHAL_TX_ERROR_VALUE",
                    "NIL_TXACTION_VALUE","EXPIRED_CHAINCODE_VALUE","CHAINCODE_VERSION_CONFLICT_VALUE","BAD_HEADER_EXTENSION_VALUE",
                    "BAD_CHANNEL_HEADER_VALUE","BAD_RESPONSE_PAYLOAD_VALUE","BAD_RWSET_VALUE","ILLEGAL_WRITESET_VALUE",
                    "INVALID_WRITESET_VALUE","NOT_VALIDATED_VALUE","INVALID_OTHER_REASON_VALUE"
            };

    /**
     * 解析block信息--并映射交易信息map--再map中添加对应区块信息
     * @param blockInfo
     * @return
     * @throws InvalidProtocolBufferException
     */
    public static List<Map> getRWSetFromBlock(BlockInfo blockInfo) throws IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CryptoException {
        List<Map> transactionList = new ArrayList<>();
        for (BlockInfo.EnvelopeInfo envelopeInfo : blockInfo.getEnvelopeInfos()) {
            String id = envelopeInfo.getCreator().getId();
            String mspid = envelopeInfo.getCreator().getMspid();

            if (envelopeInfo.getType() == BlockInfo.EnvelopeType.TRANSACTION_ENVELOPE) {
                Date timestamp = envelopeInfo.getTimestamp();
                BlockInfo.TransactionEnvelopeInfo transactionEnvelopeInfo = (BlockInfo.TransactionEnvelopeInfo) envelopeInfo;
                String transactionID = transactionEnvelopeInfo.getTransactionID();
                boolean valid = transactionEnvelopeInfo.isValid();
                byte validationCode = transactionEnvelopeInfo.getValidationCode();
                for (BlockInfo.TransactionEnvelopeInfo.TransactionActionInfo transactionActionInfo : transactionEnvelopeInfo.getTransactionActionInfos()) {
                    Map<String, Object> transactionMap = new HashMap<>();
                    //在每笔交易中添加对应区块信息
                    transactionMap.put("blockNumber", blockInfo.getBlockNumber());
                    transactionMap.put("blockHash", caculateCurrentBlockhash(blockInfo));
                    transactionMap.put("blockPreviousHash", Hex.encodeHexString(blockInfo.getPreviousHash()));
                    transactionMap.put("blockDataHash", Hex.encodeHexString(blockInfo.getDataHash()));
                    transactionMap.put("blockTransactionCount", blockInfo.getTransactionCount());
                    transactionMap.put("blockChannelId", blockInfo.getChannelId());

                    //交易具体信息
                    transactionMap.put("transactionID", transactionID);
                    transactionMap.put("timestamp", timestamp.getTime());
                    transactionMap.put("isValid", valid);
                    transactionMap.put("MSPID", mspid);
                    transactionMap.put("usercert", id);
                    transactionMap.put("validationCode", validationCode);
                    int index = validationCode;
                    int chaincodeInputArgsCount = transactionActionInfo.getChaincodeInputArgsCount();
                    String[] argus = new String[chaincodeInputArgsCount];
                    for (int i = 0; i < chaincodeInputArgsCount; i++) {
                        argus[i] = new String(transactionActionInfo.getChaincodeInputArgs(i));
                        argus[i] = argus[i].replaceAll("[\\u0000-\\u001f\b\n]","");
                    }
                    transactionMap.put("argus", argus);
                    transactionMap.put("status", transactionActionInfo.getResponseStatus());
                    transactionMap.put("endorsementsCount", transactionActionInfo.getEndorsementsCount());
                    String chaincodeIDName = transactionActionInfo.getChaincodeIDName();
                    transactionMap.put("chaincodeName", chaincodeIDName);
                    String chaincodeIDVersion = transactionActionInfo.getChaincodeIDVersion();
                    transactionMap.put("chaincodeVersion", chaincodeIDVersion);
                    TxReadWriteSetInfo rwsetInfo = transactionActionInfo.getTxReadWriteSet();
                    if (null != rwsetInfo) {
                        List<Map> rwList = new ArrayList<Map>();

                        for (TxReadWriteSetInfo.NsRwsetInfo nsRwsetInfo : rwsetInfo.getNsRwsetInfos()) {

                            Map<String, Object> rwMap = new HashMap<>();
                            Map<String, String> writeMap = new HashMap<>();
                            KvRwset.KVRWSet rws = nsRwsetInfo.getRwset();
                            String[] readSet = new String[rws.getReadsCount()];
                            int i = 0;
                            for (KvRwset.KVRead readList : rws.getReadsList()) {
                                String key = readList.getKey();
                                readSet[i++] = key;
                            }
                            rwMap.put("read", readSet);
                            for (KvRwset.KVWrite writeList : rws.getWritesList()) {
                                String valAsString = printableString(new String(writeList.getValue().toByteArray(), StandardCharsets.UTF_8));
                                writeList.getKey();
                                writeMap.put(writeList.getKey(), valAsString);
                            }
                            rwMap.put("write", writeMap);
                            rwList.add(rwMap);

                        }
                        transactionMap.put("RWSet", rwList);
                    }
                    transactionList.add(transactionMap);
                }
            }
        }
        return transactionList;
    }

    //通过blockinfo计算当前区块hash
    public  static String caculateCurrentBlockhash(BlockInfo blockInfo) throws IOException, IllegalAccessException, InvocationTargetException, InvalidArgumentException, InstantiationException, NoSuchMethodException, CryptoException, ClassNotFoundException, CryptoException, InvalidArgumentException {
        CryptoSuite cryptoSuite = CryptoSuite.Factory.getCryptoSuite();
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        DERSequenceGenerator seq = new DERSequenceGenerator(s);
        seq.addObject(new ASN1Integer(blockInfo.getBlockNumber()));
        seq.addObject(new DEROctetString(blockInfo.getPreviousHash()));
        seq.addObject(new DEROctetString(blockInfo.getDataHash()));
        seq.close();
        byte[] hash = cryptoSuite.hash(s.toByteArray());
        return Hex.encodeHexString(hash);
    }


    static String printableString(String string) {
        int maxLogStringLength = 64;
        if (string == null || string.length() == 0) {
            return string;
        }
        String ret = string.replaceAll("[^\\p{Print}]", "?");
        ret = ret.substring(0, Math.min(ret.length(), maxLogStringLength)) + (ret.length() > maxLogStringLength ? "..." : "");
        return ret;

    }


    static final Pattern reUnicode = Pattern.compile("\\\\u([0-9a-zA-Z]{4})");
    public static String decode1(String s) {
        Matcher m = reUnicode.matcher(s);
        StringBuffer sb = new StringBuffer(s.length());
        while (m.find()) {
            m.appendReplacement(sb,
                    Character.toString((char) Integer.parseInt(m.group(1), 16)));
        }
        m.appendTail(sb);
        return sb.toString();
    }
    }
