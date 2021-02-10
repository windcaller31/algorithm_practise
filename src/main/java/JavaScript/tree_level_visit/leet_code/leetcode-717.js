/**
 * @param {number[]} bits
 * @return {boolean}
 */
var isOneBitCharacter = function(bits) {
  var flag;
  for(var i=0;i<bits.length;){
    var v_0 = bits[i];
    if(v_0==1){
      flag=false;
      i+=2;
    }else if(v_0==0){
      flag=true;
      i++
    }
  }
  return flag;
};

console.log(isOneBitCharacter([1,0,1]));
