```toml
name = 'Create new user'
method = 'POST'
url = '{{url}}/users/create'
sortWeight = 1000000
id = '6561f752-7057-43a1-a8c4-e9dfe7e8b159'

[body]
type = 'JSON'
raw = '''
{
  "name": "Garcia Nzango",
  "email": "garcianzango@gmail.com",
  "password": "12345678"
}'''
```
