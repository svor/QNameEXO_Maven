1. Create new Project 'QNameEXO'
mvn archetype:create -DarchetypeGroupId=org.apache.maven.archetypes 
  -DgroupId=com.exoplatform.testtask.qname -DartifactId=QNameEXO
2. Delete App.java, TestApp.java files
3. Paste IllegalNameException.java, Parser.java, QName.java to the QNameEXO/src/main/java/com/exoplatform/testtask/qname directory
4. Paste ParserTest.java to the directory QNameEXO/src/test/java/com/exoplatform/testtask/qname 
5. Edit pom.xml file
6. Compile the project
mvn compile
7. Run JUnit test
mvn test
