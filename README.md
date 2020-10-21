# InstagramScrapper

> This java application is supposed to access an instagram's profile `(given credentials)`
>  and get its following list.

  - Selenium
  - Spring

### Installation and Execution

Requires java JRE.

Requires download of Chrome Driver at [Selenium Documentation](https://www.selenium.dev/documentation/en/webdriver/driver_requirements/)

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
| done | Improve method getUnverifiedFollowingList() |
| `to-do` | Implement a database to store the data |
| `to-do` | Make this application an RESTful API |
| `to-do` | Treat errors properly |
| `to-do` | Think about how to make the given password secure |
