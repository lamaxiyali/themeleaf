# themeleaf
#主要后端服务  
#通过fabric-gateway-sdk连接底层区块链网络，通过配置连接区块链网络配置文件实现连接网关，之后通过网关调用部署的合约  
#调用合约实现功能：  
 - 注册用户信息、信誉值、奖励值到区块链  
 - 参与用户提交参与属性集到区块链  
  ##调用多属性拍卖合约获取排名信息，根据排名信息提交感知数据  
  ##更新奖励值、信誉值  
  ##将感知数据对应hash数据上链，避免大规模数据上链，同时保证线下数据的完整性  
  ##实现对区块链区块、交易信息的获取  
#对前端提供提供api接口，提供相应json格式数据  
