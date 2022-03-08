# myaccount - hexagonal architeture

**An initial data inserted by data.sql inside resources folder 

## Transfer between accounts use case request example
```
curl --location --request POST 'localhost:8080/v1/transfers' \
--header 'Content-Type: application/json' \
--data-raw '{
"originId": 1,
"destinyId": 2,
"amount": 50
}'
```

## Account Statement use case request example
```
curl --location --request GET 'localhost:8080/v1/statements/1'
```

## Access H2 console to see changes
```
http://localhost:8080/h2-console

Obs: change JDBC URL to -> jdbc:h2:mem:test
```