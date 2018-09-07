/**
 * @param {number} n
 * @return {boolean}
 */
var hasAlternatingBits = function(n) {
  if(n<=2){
    return true;
  }
  var bit_array = [];
  while(n>1){
    bit_array.unshift(n%2);
    n=Math.floor(n/2);
  }
  bit_array.unshift(n);
  for(var i =1 ;i<=bit_array.length-1;i++){
    var j = i-1;
    if(!(bit_array[i]^bit_array[j])){
      return false;
    }
  }
  return true;
};

console.log(hasAlternatingBits(10));
