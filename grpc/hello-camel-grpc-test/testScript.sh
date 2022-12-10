echo "================== testing results ==================" > results;
mvn test -Dtest=SimpleHttp2Test#test0* | tee >>  results; echo "test0 : \n"; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test1* | tee >>  results; echo "test1 : \n"; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test2* | tee >>  results; echo "test2 : \n"; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test3* | tee >>  results; echo "test3 : \n"; cat results | grep "Time elapsed:" | tail -n 1;
mvn test -Dtest=SimpleHttp2Test#test4* | tee >>  results; echo "test4 : \n"; cat results | grep "Time elapsed:" | tail -n 1;


