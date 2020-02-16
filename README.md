### Technical challenge

Write a function that takes in a string and returns an array of the top 3 most occurring words.

### Usage

Minimum JVM version is 8.
Only pre-requisite to running the tests is to have Maven installed. 
You can then run `mvn test` and it will run the test cases.
If you would like to test out the function on the command line you can compile the package using `mvn package` 
and then you can run it with `java -cp target/topthreewords-1.0.jar Application "Replace this with whatever text you'd like to try out."`

### Algorithm steps

We use a Regex matcher to 'find' words, store the word in a HashMap, and add 1 to the count for that word.
Then we sort the HashMap by the count values and only return the top 3.