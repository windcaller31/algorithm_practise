/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
  var res = 0;
  for(var i =0;i<grid.length;i++){
    var g = grid[i];
    for(var j=0;j<g.length;j++){
      if(grid[i][j]==1){
        res = Math.max(res,find(grid,i,j));
      }
    }
  }
  return res;
};

function find(grid,r,c){
  if(r<0||r>=grid.length||c<0||c>=grid[0].length){
    return 0;
  }
  var res = 0;
  if(grid[r][c]==1){
    grid[r][c] = 0;
    res = 1 + find(grid,r-1,c) + find(grid,r+1,c) + find(grid,r,c-1) + find(grid,r,c+1);
  }
  return res;
}


console.log(maxAreaOfIsland([[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]));
