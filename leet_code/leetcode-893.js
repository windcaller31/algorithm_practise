/**
 * @param {string[]} A
 * @return {number}
 */
var numSpecialEquivGroups = function(A) {
  var total={};
  for(var i in A){
    var a = A[i];
    var b = a.split("");
    var evenB = [];
    var oddB = [];
    for(var i =0;i<b.length;i++){
      if(i%2==0){
        evenB.push(b[i]);
      }else if(i%2!=0){
        oddB.push(b[i]);
      }
    }
    evenB = evenB.sort(function(a,b){
      if(b>a){
        return -1;
      }else{
        return 1;
      }
    });
    oddB = oddB.sort(function(a,b){
      if(b>a){
        return -1;
      }else{
        return 1;
      }
    });
    total[evenB.join("")+oddB.join("")]=1;
  }
  // console.log();
  var len = 0;
  for(key in total){
    if(key!=""){
      len++;
    }
  }
  return len;
};

console.log(numSpecialEquivGroups(["abc","acb","bac","bca","cab","cba"]));
