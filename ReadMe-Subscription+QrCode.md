# women empowerment - Badges QrCode : 


## QrCode - GET :
( this will generate a QRCode for you + add the authorization jwt bearer token before you send HTTP Request ) :

```
http://localhost:8080/genrateAndDownloadQRCode/SILVER_IMAGE_PATH/350/350
```

```
http://localhost:8080/genrateAndDownloadQRCode/GOLD_IMAGE_PATH/350/350
```

```
http://localhost:8080/genrateAndDownloadQRCode/BRONZE_IMAGE_PATH/350/350
```

Badges : 
<br/>

![gold](https://i.imgur.com/XtkkmCb.png)
![silver](https://i.imgur.com/7gPz14Y.png)
![bronze](https://i.imgur.com/FmSQbn0.png)
 ![qr](https://i.imgur.com/iYoCP1p.png)


<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

________

# Gest. Subscription : 
<br/>


##CRUD :
GET / fetch All / fetch by id
```
http://localhost:8080/sub/allsubscriptions
http://localhost:8080/sub/subscriptions/{id}
```

POST / ADD
```
http://localhost:8080/sub/addsubscriptions

{
    "title": "Subscription silver couture",
    "niveau": "SILVER",
    "datedebut": "2022-02-24",
    "datefin": "2022-03-30"
}

```


PUT  / MODIFY
```
http://localhost:8080/sub/modifysubscriptions

{
    "idSubscription": 1,
    "title": "Subscription bronze couture",
    "niveau": "BRONZE"
}

```



DELETE
/empty

```
http://localhost:8080/sub/deletesubscriptions/{id}

```
