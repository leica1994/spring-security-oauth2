## Spring Security Oauth2 认证服务器,基于内存demo

- (认证地址)[http://localhost:8080/oauth/authorize?client_id=client&response_type=code] 
-  回调地址: http://localhost:8080/?code=plug0J   授权码为:plug0J
- 获取access_token
    - curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=plug0J' "http://client:secret@localhost:8080/oauth/token"
- 得到access_token
```json
    {
        "access_token": "9da713ff-961a-4b85-bca5-66cde0d3b6b1",
        "token_type": "bearer",
        "expires_in": 43199,
        "scope": "app"
    }
```