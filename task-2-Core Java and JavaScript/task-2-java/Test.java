class Test{
	private String name;

	public  String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

    public static void main(String[] args){
        String name = "Harshit";
        Test testing = new Test();
        testing.setName(name);
        System.out.println(testing.getName());
    }
}
