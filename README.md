# ONE
> From O to I.

## 基础配置

### elasticsearch
#### 创建operation-log索引及映射
```json
{
  "settings": {
    "number_of_shards": 3,
    "number_of_replicas": 1,
    "refresh_interval": "10s",
    "translog": {
      "flush_threshold_size":"1gb",
      "sync_interval":"30s",
      "durability":"async"
    }
  },
  "mappings": {
    "doc":{
      "properties":{
        "name":{
          "type":"keyword"
        },
        "age":{
          "type": "long"
        },
        "address":{
          "type":"text"
        },
        "birthday":{
           "type": "date",
           "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis" 
        }
      }
    }
  }
}
```