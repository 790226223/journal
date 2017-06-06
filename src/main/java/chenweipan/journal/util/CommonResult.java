package chenweipan.journal.util;

public class CommonResult {

	private String code;
	private Object detail;

	public CommonResult() {
	}
	/**
	 * �����룬���ݾ���ҵ��Լ�����ݣ���ʽͨ���� "buz.error.detail"
	 * 
	 * @return �����룬������ͳһ�ķ����жϴ���ԭ��
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * �������飬�������ݸ��ݽӿ����Լ����<br>
	 * ע�⣺<strong>��Ҫ͵�����ش���ջ</strong>
	 * 
	 * @return ������ϸ�����������ݵ�����ҵ������صĸ��Ӷ��󣬱��� {@link BindingResult} ֮��Ķ���
	 */
	public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonResult [code=");
		builder.append(code);
		builder.append(", detail=");
		builder.append(detail);
		builder.append("]");
		return builder.toString();
	}

}
