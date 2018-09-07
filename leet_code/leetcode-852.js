/**
 * @param {number[]} A
 * @return {number}
 */
var peakIndexInMountainArray = function(A) {
  var max_index = 0;
  var max = A[0];
  for(var i =0 ;i<A.length;i++){
    if(max<A[i]){
      max_index = i ;
      max = A[i];
    }
  }
  return max_index;
};

console.log(peakIndexInMountainArray([0,1,0]));
