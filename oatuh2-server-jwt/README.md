## Spring Security Oauth2 认证服务器,基于jwt认证demo

- 生成jwt.jks
```text
keytool -genkeypair -alias jwt -validity 3650 -keyalg RSA -dname "CN=jwt,OU=jwt,O=jwt,L=zurich,S=zurich,C=CH" -keypass likun1202 -keystore jwt.jks -storepass likun1202
```
- 生成公钥
```text
keytool -list -rfc -keystore jwt.jks | openssl x509 -inform pem -pubkey
```