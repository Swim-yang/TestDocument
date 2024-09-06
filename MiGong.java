public class MiGong{
	public static void main(String[] args){
		int[][] map = new int[8][7];
		for(int i = 0; i < 7; i++){
			map[0][i] = 1;
			map[7][i] = 1;
		}

		for(int i = 0; i < 8; i++){
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;

		System.out.println("=======地图======");
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		//
		T t1 = new T();
		t1.finfWWay(map, 1, 1);
		System.out.println("\n=====找路的情况=====");
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class T{
	//fingWay方法专门找出迷宫的路径
	//如果找到，返回true 否则返回false
	//map二维数组，即表示迷宫
	//i，j是老鼠的位置，初试化的位置未（1.1）
	//0表示可以走 1表示障碍物 2表示可以走 3 表示走过，但是走不通是死路
	//map【6】【5】 = 2 说明找到通路，就可以结束，否则继续找
	//确定老鼠找路策略 下 -> 右 -> 上 -> 左
	public boolean finfWWay(int[][] map, int i, int j){
		if(map[6][5] == 2){
			return true;
		}else{
			if(map[i][j] == 0){//当前位置为0，说明可以走
				//假定可以走通
				map[i][j] = 2;
				//使用找路策略，来确定该位置是否真的可以走通
				//下 -> 右 -> 上 ->左
				if(finfWWay(map, i + 1, j)){
					return true;
				}else if(finfWWay(map, i, j + 1)){
					return true;
				}else if(finfWWay(map, i - 1, j)){
					return true;
				}else if(finfWWay(map, i, j - 1)){
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}
			}else{
				return false;
			}
		}
	}
}