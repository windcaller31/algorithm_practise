/**
 * @param {string[]} A
 * @return {number}
 */
var minDeletionSize = function(A) {
  var eachLen = A[0];
  var count = 0;
  var len = A[0].length;
  var router = {};
  for(var i=1;i<A.length;i++){
    var a0 = A[i-1];
    var a1 = A[i];
    for(var j=0;j<len;j++){
      if((a0.charAt(j)>a1.charAt(j))&&(router[j]!=0)){
        count++;
        router[j] = 0;
        continue;
      }
    }
  }
  console.log(router);
  return count;
};

console.log(minDeletionSize([
  "zyx",
  "wvu",
  "tsr"]));
