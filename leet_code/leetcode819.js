/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
 String.prototype.replaceAll = function(s1,s2){
   return this.replace(new RegExp(s1,"gm"),s2);
}
var mostCommonWord = function(paragraph, banned) {
  paragraph = paragraph.replaceAll("['?!,; .]+", " ");//去符号操作
  paragraph = paragraph.toLowerCase();
  paragraph = paragraph.split(" ");
  var p = {};
  var b = {};
  for(key in banned){
    b[banned[key]] = 1;
  }
  for(key in paragraph){
    if(typeof(b[paragraph[key]])=='undefined'){
      if(typeof(p[paragraph[key]])=='undefined'){
        p[paragraph[key]] = 1
      }else {
        p[paragraph[key]] = 1 + p[paragraph[key]] ;
      }
    }
  }
  var max = {};
  for(key in p){
    if(key != ""){
      if(typeof(max.m)=='undefined'){
        max["key"] = key;
        max["m"] = p[key];
      }else if(max.m<=p[key]){
        max["key"] = key;
        max["m"] = p[key];
      }
    }
  }
  return max["key"];
};

mostCommonWord("a.",[])
