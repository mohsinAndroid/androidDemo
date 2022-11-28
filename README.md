# android-app-master
Example App with a List Page and a Detail Page

For this example I used new york times APIs: `http://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=qSGw4MzuJEZAofAY3pM9uBHOCw79Thar`.

Some notes:
* Code strictly follows SOLID and Clean Architecture principles
* Code has been written after the tests in a pure TDD fashion
* Tests have been written without the use of Mocking libraries since it is easy to create fakes when each unit depends on an abstract collaborator (as per DIP).
* For the DI framework I used Dagger Hilt since it is the recommended way from Google.
* I used Coroutines as Asynchronous framework since this is the new recommeded way.
