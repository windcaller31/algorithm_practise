var numJewelsInStones = function(J, S) {
  J = J.split("");
  var jel ={};
  for(var key in J){
    jel[J[key]]=1;
  }
  S = S.split("");
  var sum = 0;
  for(var key in S){
    if(jel[S[key]]==1){
      sum++;
    }
  }
  return sum;
};
