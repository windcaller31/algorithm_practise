/**
 * @param {string} A
 * @param {string} B
 * @return {boolean}
 */
var rotateString = function(A, B) {
  if(A==B){
    return true;
  }
  var s = A.substr(A.length-1,1) + A.substr(0,A.length-1);
  while(s != B && s != A){
    s = s.substr(s.length-1,1) + s.substr(0,s.length-1);
    console.log(s);
  }
  if(s==A){
    return false;
  }
  if(s==B){
    return true
  }
};

console.log(rotateString("abcde","cdeab"));
