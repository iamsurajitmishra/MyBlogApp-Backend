## REST API for blog posts resource -

![img_1.png](img_1.png)

* Post payload:
```
  {
  "title": "My title",
  "description": "My description",
  "content": "My content" 
   }
```

![img_2.png](img_2.png)

* Comment payload :
````
{
  "name":"Mishra",
  "email":"mishrasurajit69@gmail.com",
   "body":"Awesome! blog"
}
````

* Post response DTO:

`api-url-path : http://localhost:8080/api/v1/posts?pageNo=0&pageSize=5`

````

{
    "content": [
        {
            "id": 1,
            "title": "atitle",
            "description": "adescription",
            "content": "acontent"
        },
        {
            "id": 2,
            "title": "btitle",
            "description": "bdescription",
            "content": "bcontent"
        },
        {
            "id": 3,
            "title": "ctitle",
            "description": "cdescription",
            "content": "dcontent"
        },
        {
            "id": 4,
            "title": "dtitle",
            "description": "ddescription",
            "content": "dcontent"
        },
        {
            "id": 5,
            "title": "etitle",
            "description": "edescription",
            "content": "econtent"
        }
    ],
    "pageNo": 0,
    "pageSize": 5,
    "totalElement": 12,
    "last": false
}

````