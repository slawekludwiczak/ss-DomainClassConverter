There are 2 users:
1. user / pass (USER role)
2. admin / hard (ADMIN role)

users can edit only his username and password in user panel: http://localhost:8080/user/edit

admins can edit username, password and user roles in admin panel: http://localhost:8080/admin/edit-user/1

When domain objects are used in presentation layer as DTO's and update action in service layer (UserService) is implemented such way, 
that not-null fields are updated, the user can modify the form and send additional field with role id.
Because Spring uses DomainClassConverter by default, user can edit  his roles, by setting only role_id.

To reproduce attack:
1. Log in as user (user / pass)
2. Go to http://localhost:8080/user/edit
3. Modify the page source in browser dev tools as it is shown in userEditForm.html
4. Select ADMIN role
5. Send POST request:
```
POST /user/update
id:         1
username:   user
password:   pass
role:       1
```
6. User just changed his role from USER to ADMIN

This is very specific case and I don't know if it should be treated more like programmer's bug because of poorly designed update action in service layer or security vulnerability, 
but if the DomainClassConverter would not retrieve Role object by role id automatically, the attack would not be possible.
