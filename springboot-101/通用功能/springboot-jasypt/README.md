

### 启动命令 并注入 秘钥配置 

>jasypt.encryptor.password=mypassword

```java

java -jar -Djasypt.encryptor.password=mypassword XXX-jasypt.jar

脚本文件
        
java -jar -Djasypt.encryptor.password=${JASYPT_PASSWORD} xxx.jar
```

### 生成待加密的文本内容

> maven包路径 D:\maven_lib\org\jasypt\jasypt\1.9.3\jasypt-1.9.3.jar 

> input  待加密文本

> password 秘钥文本

```java
java -cp  D:\maven_lib\org\jasypt\jasypt\1.9.3\jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="mypassword" password=35579B7F9C8CB15E
``` 

参考文件  https://blog.yamell.com/java/415.html

