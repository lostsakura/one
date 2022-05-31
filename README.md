# ONE
> From O to I.

## 基础配置

### logstash
#### 消费kafka中的日志到es
logstash.conf
```text
input {
  kafka {
    bootstrap_servers => ["localhost:9092"]
    group_id => "logstash"
    topics => ["operation-log"]
    consumer_threads => 5
    decorate_events => true
    codec => json {
      charset => ["UTF-8"]
    }
  }
}

filter {
  mutate {
    remove_field => ["@version"]
  }
}

output {
  elasticsearch {
    hosts => ["localhost:9200"]
    index => "operation-log"
    template => "E:\Service\ELK\logstash-7.17.2\config\operation-log_template.json"
    template_name => "logstash"
    template_overwrite => true
  }
}
```
operation-log_template.json
```json
{
  "settings": {
    "number_of_shards": 3,
    "number_of_replicas": 0,
    "refresh_interval": "10s",
    "translog": {
      "flush_threshold_size": "512mb",
      "sync_interval": "30s",
      "durability": "async"
    }
  },
  "mappings": {
    "properties": {
      "host": {
        "type": "keyword"
      },
      "port": {
        "type": "integer"
      },
      "clientIp": {
        "type": "ip"
      },
      "requestUrl": {
        "type": "text"
      },
      "httpMethod": {
        "type": "keyword"
      },
      "headers": {
        "type": "text"
      },
      "type": {
        "type": "keyword"
      },
      "method": {
        "type": "text"
      },
      "parameter": {
        "type": "text"
      },
      "responseBody": {
        "type": "text"
      },
      "logTime": {
        "type": "date"
      },
      "costTime": {
        "type": "long"
      },
      "threadName": {
        "type": "text"
      },
      "threadId": {
        "type": "long"
      },
      "success": {
        "type": "boolean"
      },
      "@timestamp": {
        "type": "date"
      }
    }
  }
}
```