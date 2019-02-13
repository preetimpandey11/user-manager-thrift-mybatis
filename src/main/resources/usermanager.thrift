namespace java com.user


struct User {
1: optional i32 id,
2: string gname,
3: string lname,
4: i32 ssn,
5: string email
}

service UserService {

User getUser(1: i32 id),
void addUser(1: User user),
list<User> getAll(),
void deleteUser(1: i32 id),
void updateUser(1: i32 id, 2: User user)

}