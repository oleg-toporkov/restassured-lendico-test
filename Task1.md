# [Login page](https://my.lendico.de/)

## Bugs:

### Nothing happens on UI when login with non-existing account
**Description:**  
When trying to login to https://my.lendico.de/ with non-existing email nothing happens on UI.  
Backend returns 401 so missing error on UI only.  
Steps to reproduce:
1. Open `https://my.lendico.de/`
2. Type valid non-existing email: `toporkov.oleg@gmail.com`
3. Type any password that satisfies requirements (for example `QWERTYqwerty1234!@#$`)
4. Click login

Expected result:  
Error message is displayed that user does not exist.  

Actual result:  
Login page still displayed with no errors  

**Reporter:** Oleg Toporkov  
**Priority:** Medium  
**Severity:** Medium  
**Environment:** PROD, Firefox, Chrome (doesn't really matter)  

---

### Nothing happens on UI when login with incorrect email
**Description:**  
When trying to login to https://my.lendico.de/ with username that is not valid email nothing happens on UI.  
Backend returns 405 so missing error on UI only.  
There is also same issue for `Passwort vergessen` functionality.  
Steps to reproduce:
1. Open `https://my.lendico.de/`
2. Type not valid email: `toporkov.oleg`
3. Type any password that satisfies requirements (for example `QWERTYqwerty1234!@#$`)
4. Click login

Expected result:  
Error message is displayed that provided email didn't pass validation.  

Actual result:  
Login page still displayed with no errors.  
CORS errors are in console.  

**Reporter:** Oleg Toporkov  
**Priority:** High  
**Severity:** Medium  
**Environment:** PROD, Firefox, Chrome (doesn't really matter)  

Attachments:  
Browser log  
```
Cross-Origin Request Blocked: The Same Origin Policy disallows reading the remote resource at https://www.lendico.de/public-api/v1/log. (Reason: CORS header ‘Access-Control-Allow-Origin’ missing).
Cross-Origin Request Blocked: The Same Origin Policy disallows reading the remote resource at https://www.lendico.de/public-api/v1/log. (Reason: CORS request did not succeed).
Error: Network Error vendor.20840f96bcd8aab91267.js:34:28400
```

---

## Feature requests
1. Email field should be first validated on UI.  
For now frontend performs no validation whether user submitted not valid email or even nothing (frontend sends `null`).  
To provide better experience user should know in advance that he/she provided bad value.  
Also it's not good practice to send to the backend values that are even not close to correct.  

2. For empty or incorrect password frontend also should not preform any HTTP requests (just makes no sense).  
Especially as error message is displayed on UI.  

3. Password field validations for non-empty user input are obsolete and confusing.  
As user I would be really confused seeing messages that my password is short or not strong enough on **login** page.  
It looks like user sign-up page and can lead to misunderstanding.  

4. No criteria of strong password given.  
Even if we decided to perform password validation, it's not really what is strong password as no hints provided.  
