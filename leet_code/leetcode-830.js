/**
 * @param {string} S
 * @return {number[][]}
 */
var largeGroupPositions = function(S) {
  var target = S.split("");
  var mid = [];
  var i = 0;
  var j = 1;
  while(j<=target.length-1){
    if(target[i]==target[j]){
      j++;
    }else{
      if(j-i>=3){
        mid.push([i,j-1]);
      }
      i = j;
      j = i+1;
    }
  }
  if(j-i>=3){
    mid.push([i,j-1]);
  }
  return mid;
};


console.log(largeGroupPositions("abbxxxxzzy"));
