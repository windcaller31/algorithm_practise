/**
 * @param {number} buckets
 * @param {number} minutesToDie
 * @param {number} minutesToTest
 * @return {number}
 */
var poorPigs = function(buckets, minutesToDie, minutesToTest) {
  if(buckets<=1){
    return 0;
  }
  var col = parseInt(minutesToTest/minutesToDie)+1;
  var x = 1;
  while(x<=buckets){
    if(Math.pow(col,x)>=buckets){
      return x;
    }
    x++;
  }
  return -1;
};
