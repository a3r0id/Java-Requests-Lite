# Java-Requests-Lite
 An extremely lightweight, high-level HTTP requests module, inspired by Python Requests.
 There is still a TON of work to be done.
 So far, I have only added GET, HEAD, POST HTTP methods but plan on adding PUT, STREAM & DELETE in the near future.
 Enjoy!

## Installation - IntelliJ

> 1) Import contents of `out` (precompiled) to your intended project or include `src` (from source).

## Usage - GET
````java
public class Test{
    public Main(){
        Requests request = new Requests();
        ResponseObject response = request.get(
                "https://google.com",
                "",
                {{"Content-Type", "text/html; charset=UTF-8"}, {"Authorization", "Basic YWxhZGRpbjpvcGVuc2VzYW1l"}},
                "UTF-8"
        );
        System.out.println(String.format("Status Code: %s", response.status));
        System.out.println(String.format("Response Body: %s", response.text));
    }
} 
````

## Usage - POST (JSON)
````java
public class Test{
    public Main(){
        Requests request = new Requests();
        ResponseObject response = request.post(
                "https://reqbin.com/echo/post/json",
                "{\"Message\": \"Hello World!\"}",
                {{"Content-Type", "application/json"}},
                "UTF-8"
        );
        System.out.println(String.format("Status Code: %s", response.status));
        System.out.println(String.format("Response Body: %s", response.text));
    }
} 
````