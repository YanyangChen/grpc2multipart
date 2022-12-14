echo "================== testing results ==================" > results;
mvn test -Dtest=SimpleHttp2Test#test0* | tee >>  results; echo "test0 : "; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test1* | tee >>  results; echo "test1 : "; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test2* | tee >>  results; echo "test2 : "; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test3* | tee >>  results; echo "test3 : "; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test4* | tee >>  results; echo "test4 : "; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test5* | tee >>  results; echo "test5 : "; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test6* | tee >>  results; echo "test5 : "; cat results | grep "Time elapsed:" | tail -n 1;


