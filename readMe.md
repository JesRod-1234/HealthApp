# Users

### POST: Create new user

`http://localhost:8080/users/signup`


```
{
  "firstname":"Tom",
  "lastname" : "Arnold",
  "email" : "tom@gmail",
  "phoneNumber" : "22222222",
  "password": "xxxx"	
}
```
### GET: Get all users

`http://localhost:8080/users`

### GET: Find user by Id

`http://localhost:8080/users/id`

### DELETE: Delete Student by Id

`http://localhost:8080/users/id`

### PUT: Add Aerobics to users

`http://localhost:8080/users/userid`/aerobic/aerobicid`

### PUT: Add Anaerobics to users

`http://localhost:8080/users/userid`/anaerobic/anaerobicid`

### PUT: Add Mindfulness to users

`http://localhost:8080/users/userid`/mindfulness/mindfulnessid`

### PUT: Add Diet to users

`http://localhost:8080/users/userid`/diet/dietid`

### PUT: Add Equipment to users

`http://localhost:8080/users/userid`/equipment/equipmentid`

### GET: Health Check

`http://localhost:8080/users/userid`

# Aerobics

### POST: Create Aerobic user

`http://localhost:8080/aerobics`
```
{
  "name":"swimming",
  "duration" : "40"  	
}
```
### GET: Get all Aerobic users

`http://localhost:8080/aerobics`

### GET: Find Aerobic user by Id

`http://localhost:8080/aerobics/id`

### DELETE: Delete aerobic user by Id

`http://localhost:8080/aerobics/id`

# Anaerobics

### POST: Create Anaerobic user

`http://localhost:8080/anaerobics`

```
{
   "name":"dumbbells",
  "numberOfRepititions" : "10"  	
}
```
### GET: Get all Anaerobic users

`http://localhost:8080/anaerobics`

### GET: Find Anaerobic user by Id

`http://localhost:8080/anaerobics/id`

### DELETE: Delete Anaerobic user by Id

`http://localhost:8080/anaerobics/id`

# Mindfulness

### POST: Create Mindfulness user

`http://localhost:8080/mindfulness`

```
{
  "name":"meditation",
  "duration" : "30"  	
}
```
### GET: Get all Mindfulness users

`http://localhost:8080/mindfulness`

### GET: Find Mindfulness user by Id

`http://localhost:8080/mindfulness/id`

### DELETE: Delete Mindfulness user by Id

`http://localhost:8080/mindfulness/id`

# Diet

### POST: Create Diet

`http://localhost:8080/diet`

```
{
    "nameOfDish":"dumbbells",
    "numberOfCalories" : "10",
	"mealTimes":"2"
}
```
### GET: Get all Diet

`http://localhost:8080/diet`

### DELETE: Delete Diet  by Id

`http://localhost:8080/diet/id`

# Equipment

### POST: Create Equipment

`http://localhost:8080/equipment`

```
{
    "nameOfDish":"dumbbells",
    "numberOfCalories" : "10",
	"mealTimes":"2"
}
```
### GET: Get all Equipment

`http://localhost:8080/equipment`

### DELETE: Delete Equipment  by Id

`http://localhost:8080/equipment/id`













```