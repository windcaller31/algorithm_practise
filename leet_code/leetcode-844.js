/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function(S, T) {
    var s = S.split("");
    var t = T.split("");
    var s1 = [];
    var t1 = [];
    for(var i in s){
      if(s[i]=="#"){
        s1.pop();
      }else{
        s1.push(s[i]);
      }
    }
    for(var i in t){
      if(t[i]=="#"){
        t1.pop();
      }else{
        t1.push(t[i]);
      }
    }
    s1=s1.join("");
    t1=t1.join("");
    // console.log(s1,t1);
    if(s1==t1){
      return true;
    }else{
      return false;
    }
  };

console.log(backspaceCompare("ab#c","ad#c"));
