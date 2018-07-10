function KMP( ts,  ps) {
 var t = ts.split("");
 var p = ps.split("");
 var i = 0; // 主串的位置
 var j = 0; // 模式串的位置
 var next = getNext(ps);
 console.log('next,',next);
 while (i < t.length && j < p.length) {
    if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i,说明i之前的部分都不匹配，当然j也要归0
      i++;
      j++;
    } else {
     // i不需要回溯了
     // i = i - j + 1;
     j = next[j]; // j回到指定位置
   }
 }
 if (j == p.length) {
     return i - j;
  } else {
     return -1;
  }
}

function getNext( ps) {
   var p = ps.split("");
   var next = [];
   next[0] = -1;
   var j = 0;
   var k = -1;
   while (j < p.length - 1) {
      if ((k == -1 )|| (p[j] == p[k])) {
        next[++j] = ++k;
      } else {
        k = next[k];
      }
   }
   return next;
}

console.log(KMP("11112233","233"));
