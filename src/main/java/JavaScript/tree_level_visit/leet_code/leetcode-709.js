/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
  var len = str.length;
  var result = "";
  for(var i =0 ; i<=len-1;i++){
    var p = str.charAt(i);
    if(p.charCodeAt()>='A'.charCodeAt()&&p.charCodeAt()<'a'.charCodeAt()){
      result+=String.fromCharCode(p.charCodeAt()+("a".charCodeAt()-"A".charCodeAt()));
    }else{
      result+=p;
    }
  }
  return result;
};

console.log(toLowerCase("&"));
