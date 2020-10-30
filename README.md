# InstagramScrapper

> This java application is supposed to access an instagram's profile `(given credentials)`
>  and get its following list.
>
> The main purpose of this application is to use and improve techniques and knowledges that will be guided by Selenium use. In other words: the error treatment, project pattern, objects mapper, use of database and, of course, the creation of a RESTful API that is able to accomplish its goal (comment on instagram post). 

  - Selenium
  - Spring
  - Basic Javascript
  - Facade Pattern
  - H2 database

### Installation and Execution

Requires java JRE.

Requires download of Chrome Driver at [Selenium Documentation](https://www.selenium.dev/documentation/en/webdriver/driver_requirements/).

Change `selenium.browserPath` tag at `application.properties` file with the path to `chromedriver.exe` you just downloaded. 

Run the following commands:

```sh
$ cd path_to_folder_target
$ javar -jar InstagramScrapper-0.0.1-SNAPSHOT.jar
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
| `in progress` | Map errors |
| `to-do` | Update Installation and Execution section |
| `to-do` | Incorporate Lombok |
| `to-do` | Check if following account is comercial |
| `to-do` | Think about how to make the given password secure |