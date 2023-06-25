# Instuction for running the app
1. To run the app, you will need to create a unit tests using JUnit and replace <access_token> with the actual access token and http://host:port/api_path with the actual URL of your API.

2. Then, run the following command to build the Docker image:

```docker build -t <docker_username>/<image_name>:<tag_name>```

*Replace <docker_username>, <image_name>, and <tag_name> with the actual values. For example:*

docker build -t johnsmith/todo-server:latest .

3. Finally, run the following command to push the Docker image to Docker Hub:

docker push <docker_username>/<image_name>:<tag_name>

*Replace <docker_username>, <image_name>, and <tag_name> with the actual values. For example:*

docker push johnsmith/todo-server:latest 

4. Create a Docker Compose file:
Create a file named "docker-compose.yml" in the root directory of your project and add the following code:

Docker Compose file.txt

*Replace <docker_username>, <image_name>, <tag_name>, <google_client_id>, <google_client_secret>, <facebook_client_id>, <facebook_client_secret>, <github_client_id>, and <github_client_secret> with the actual values. For example:*

example of Docker Compose file.txt

# Test the APIs using curl with appropriate authentication tokens:
1. Sign in:
Get an access token from the authentication provider (Google, Facebook, or GitHub).
Replace <access_token> in the following command with the obtained access token.
Replace http://host:port/api_path/signin with the actual URL of the sign-in API.
Run the following command:

*curl -H "Authorization: Bearer <access_token>" http://host:port/api_path/signin*

2. Add a TODO item:
Replace <access_token> in the following command with the obtained access token.
Replace http://host:port/api_path/todo with the actual URL of the add-TODO-item API.
Replace TODO item with the actual title of the TODO item to be added.
Run the following command:

*curl -H "Authorization: Bearer <access_token>" -X POST -d '{"title": "TODO item"}' http://host:port/api_path/todo*

3. Delete a TODO item:
Replace <access_token> in the following command with the obtained access token.
Replace http://host:port/api_path/todo/<todo_id> with the actual URL of the delete-TODO-item API, where <todo_id> is the ID of the TODO item to be deleted.
Run the following command:

*curl -H "Authorization: Bearer <access_token>" -X DELETE http://host:port/api_path/todo/<todo_id>*

4. List all TODO items:
Replace <access_token> in the following command with the obtained access token.
Replace http://host:port/api_path/todo with the actual URL of the list-all-TODO-items API.
Run the following command:

*curl -H "Authorization: Bearer <access_token>" http://host:port/api_path/todo*

5. Mark a TODO item as completed:
Replace <access_token> in the following command with the obtained access token.
Replace http://host:port/api_path/todo/<todo_id> with the actual URL of the mark-TODO-item-as-completed API, where <todo_id> is the ID of the TODO item to be marked as completed.
Run the following command:

*curl -H "Authorization: Bearer <access_token>" -X PUT http://host:port/api_path/todo/<todo_id>*
