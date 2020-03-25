package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class T12_Equals_hashCodeTest {

	/*
	 *  HashSet, HasgMap, Hashtable과 같은 객체들을 사용 할 경우,
	 *  객체가 서로 같은지를 비교하기 위해 equals()메서드와 hasgCode()메서드를 호출한다.
	 *  그래서, 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야한다. HasgSet, HashMap,
	 *  Hashtable에서는 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	 *  
	 *  -equals()메서드는 두 객체의 내용(값)이 같은지 비교하는 메서드이고,
	 *  -hashCode()메서드는 두 객체가 같은 객체인지를 비교하는 메서드 이다.
	 *  
	 *  equals()메서드와 hashCode()메서드에 관련된 규칙
	 *  1. 두 객체가 같으면 반드시 같은 hashCode를 가져야 한다.
	 *  2. 두 객체가 같으면 equals()메서드를 호출했을때 true를 반환해야 한다.
	 *  	즉, 객체 a,b가 같다면 a.equals(b) 와 b.equals(a) 둘다 true이어야 한다.
	 *  3. 두 객체의 hashCode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
	 *  	하지만, 두 객체가 같으면 반드시 hashCode가 같다.
	 *  4. equals()메서드를 override하면 반드시 hashCode()메서드도 override해야 한다.
	 *  5. hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로
	 *  	한 정수값을 반환한다.
	 *  	그러므로, 클래스에서 hashCode()메서드를 override하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
	 *  
	 *  - hashCode()메서드에서 사용하는 '헤싱 알고리즘'에서 서로 다른 객체에 대하여 같은 hashCode값을 만들어 낼수 있다.
	 *   그래서 객체가 같지 않더라도 hashCode가 같을 수 있다.
	 */
	
	public static void main(String[] args) {
		Person p1 = new Person(1,"홍길동");
		Person p2 = new Person(1,"홍길동");
		Person p3 = new Person(1,"남희순");

		System.out.println("p1.equals(p2) :" + p1.equals(p2));
		System.out.println("p1 == p2 : "+ (p1 == p2));
		System.out.println(p1.hashCode());
		
		Set<Person> set = new HashSet<>();
		
		set.add(p1);
		set.add(p2);
		
		System.out.println("p1,p2 등록후 데이터 ..");
		for(Person p : set) {
			System.out.println(p1.getId()+ " : "+ p.getName());
		}
		
		
		System.out.println("add(p3) 성공여부 : "+set.add(p3));
		System.out.println("add(p3) 후 데이터...");
		for(Person p : set) {
			System.out.println(p1.getId()+ " : "+ p.getName());
		}
		
		
		System.out.println("remove(p2) 성공여부 : " +set.remove(p2));
		System.out.println("remove(p2) 후 데이터...");
		for(Person p : set) {
			System.out.println(p1.getId() + " : " + p.getName());
		}
		
		
	}
}

class Person{
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}














