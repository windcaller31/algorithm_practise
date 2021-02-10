/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var smallestRangeI = function(A, K) {
  A = A.sort(function(a,b){
    return a-b;
  });
  console.log(A);
  if(A[A.length-1]-A[0]<2*K){
    return 0;
  }else{
    return (A[A.length-1]-K)-(A[0]+K)
  }
};

console.log(smallestRangeI([0,10],2));
