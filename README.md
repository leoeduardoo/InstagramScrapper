# InstagramScrapper

> This java application is supposed to access an instagram's profile `(given credentials)`
>  and get its following list.
>
> The main purpose of this application is to use and improve techniques and knowledges that will be guided by Selenium use. In other words: the error treatment, project pattern, objects mapper, use of database and, of course, the creation of a RESTful API that is able to accomplish its goal (comment on instagram post). 

  - Selenium
  - Spring
  - Basic Javascript
  - Facade Pattern
  - H2 Database

### Installation and Execution

Requires java JRE.

Requires download of Chrome Driver at [Selenium Documentation](https://www.selenium.dev/documentation/en/webdriver/driver_requirements/).

Change `selenium.browserPath` tag at `application.properties` file with the path to `chromedriver.exe` you just downloaded. 

Run application.

### Endpoints 

##### Sign in (GET):

`localhost:8080/instagramscrapper/access?username=YOUR_USERNAME`

> This endpoint uses the given username to access the login page and sign in 

------------------------------------------------------------

##### Get profile info (GET):

`localhost:8080/instagramscrapper/profile?username=YOUR_USERNAME`

> This endpoint uses the given username (now stored in the database) to get profile info (followers and following quantities and the full non verified following list)

------------------------------------------------------------

##### Comment (POST):

`localhost:8080/instagramscrapper/comment`

> This endpoint uses the given username and instagram post url to use the logged account to comment, following username by following username, successively

body:
```json
{
    "username":"YOUR_USERNAME",
    "postUrl":"INSTAGRAM_POST_URL"
}
```

### TO-DO

This application is currently being written. Check the next steps:

| Status | Implement detais |
| ------ | ------ |
| done | Do login |
| done | Access profile page and get some info |
| done | Get the full list of following |
| done | Get only username from list of following |
| done | Check if scroll is at bottom so don't scroll anymore |
| done | Improve method getUnverifiedFollowingUsernameList() |
| done | Remove post owner username from list |
| done | Comment username by username on a post |
| done | Implement a database to store the data |
| done | Make this application an RESTful API |
| done | Remove bug where browser opens at start |
| done | Treat errors properly |
| done | Update Installation and Execution section |
| done | Think about how to make the given password secure (do not store it! ) |
| `in progress` | Map errors |
| `to-do` | Incorporate Lombok |
| `to-do` | Check if following account is commercial (maybe one day) |
