var checkPerfectNumber = function(num) {
  if(num == 0){
    return false;
  }
  var divisors = getDivisors(num);
  var sum = 0;
  for(var key in divisors){
    sum+=divisors[key];
  }
  if(sum==num){
    return true;
  }
  return false;
};

function getDivisors(num){
  var num_2 = num/2;
  var divisors = [];
  for(var i=1;i<=num_2;i++){
    if(num%i==0){
      divisors.push(i);
    }
  }
  return divisors;
}
