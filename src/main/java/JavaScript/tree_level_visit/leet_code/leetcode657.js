var judgeCircle = function(moves) {
    moves = moves.split("");
    var i = 0;
    for(var key in moves){
      if(moves[key]=="L"){
        i--;
      }
      if(moves[key]=="R"){
        i++;
      }
    }
    if(i!=0){
      return false;
    }

    for(var key in moves){
      if(moves[key]=="U"){
        i--;
      }
      if(moves[key]=="D"){
        i++;
      }
    }
    if(i==0){
      return true;
    }else{
      return false;
    }
};
