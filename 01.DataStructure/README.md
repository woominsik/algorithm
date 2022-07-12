# Data Structre (자료구조)</h1>
***
<h2>1. 큐</h2>
<p>큐는 FIFO(First In First Out)의 자료구조로 먼저 들어온 데이터가 가장 먼저 나가는 자료구조를 말한다.</p>
<p>큐의 한쪽 끝은 Front, 다른 한쪽은 Rear로 두고 Front에서는 삭제 연산만, Rear에서는 삽입연산만 진행하게 된다.</p>
<p>큐 자료구조의 메소드 정리</p>
<ul>
<li> .add(객체) : 객체추가(성공시true /실패시 저장공간이 부족하면 예외발생)</li>
<li> .offer(객체) : 객체추가(성공시true / 실패시false)</li>
<li> .remove() : 객체를 꺼내서 반환(비어있으면 예외발생)</li>
<li> .poll() : 객체를 꺼내서 반환(비어있으면 null)</li>
<li> .element() : 삭제없이 요소 읽기(비어있으면 예외발생)</li>
<li> .peek() : 삭제없이 요소 읽기(비어있으면 null)</li>
<li> .isEmpty() : 해당 큐가 비어있는 지 확인</li>
</ul>

<h2>2. 스택</h2>
<p>스택은 LIFO(Last In First Out)의 자료구조로 가장 마지막으로 들어온 데이터가 가장 먼저 나가는 자료구조를 말한다.</p>
<p>큐와는 달리 한쪽 끝에서 삽입 연산과 삭제 연산이 동시에 이루어진다.</p>
<p>스택 자료구조의 메소드 정리</p>
<ul>
<li> .push() : 	Stack에 객체 저장</li>
<li> .pop() : 	Stack 맨위의 객체를 꺼내서 반환</li>
<li> .peek() : 	Stack 맨위의 객체 반환(꺼내지 않음)</li>
<li> .size() : Stack의 크기 반환</li>
<li> .isEmpty() : Stack이 비어있으면 true 반환</li>
<li> .contains(객체) : 해당 객체가 Stack내에 들어있는 지 확인</li>
</ul>
<h2>3. 덱(Deque)</h2>


<h2>4. 맵(Map)</h2>

<h2>5. 셋(Set)</h2>

## 6.우선순위 큐(Priority Queue)
