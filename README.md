# aws-jdbc-secret-key-rotate-poc

## Preparation steps
- Assume your machine already setup AWS credentials
- Create RDS MySQL DB in AWS (free tier will do)
    - Give the default starting table name
    ![image](https://user-images.githubusercontent.com/21075895/133743023-5315d12f-54a4-4124-893c-3757b1877e3c.png)

    - Make sure to enable public access and give inbound TCP 3306 port to the instance
    ![image](https://user-images.githubusercontent.com/21075895/133744071-7a1fd515-2470-46ed-8c11-b224cf0a4771.png)
    ![image](https://user-images.githubusercontent.com/21075895/133744321-f20cbee1-0fc8-47af-b880-80ce6c1adbdf.png)

- Create RDS Secret in AWS with key auto rotation on
- in project `application.properties`
    - Replace `AWS_MYSQL_PUBLIC_IP (starting-db-url)` with your DB instance `public ip address`
    - Replace `MY_DB (starting-db)` with `default starting table name`
    - Replace `MY_SECRET_NAME (my-secret)` with your `secret name` created earlier
- start project, the flyway will start migrating test data
## Start testing
- calling to endpoint `GET http://localhost:8888/result`
- rotate the key via Secrets Manager console -> `Rotate secret immediately`

![image](https://user-images.githubusercontent.com/21075895/133738983-b8516751-b0aa-4fd6-9451-36602411890a.png)

- try calling to endpoint `GET http://localhost:8888/result` again and see if request is still success or not
> In this step, you can use testing tool like JMeter, K6, etc., to keep the concurrent request hitting this endpoint
> and try to change the data while the tool is running to see the changes reflect in console.
