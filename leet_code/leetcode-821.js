/**
 * @param {string} S
 * @param {character} C
 * @return {number[]}
 */
var shortestToChar = function(S, C) {
  var position = [];
  var s = S.split("");
  var result = [];
  for(var i=0;i<s.length;i++ ){
    if(s[i]==C){
      position.push(i);
    }
  }
  for(var j=0;j<s.length;j++ ){
    var min = s.length;
    for(var k=0;k<position.length;k++){
      var distance = Math.abs(j-position[k]);
      min = Math.min(min,distance);
    }
    result.push(min);
  }
  return result;
};

console.log(shortestToChar("loveleetcode","e"));
