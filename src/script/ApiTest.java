
package script;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resources.Global;
import resources.Payloads;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTest {

	@Test
	public void Main() {
		// TODO Auto-generated method stub

		System.out.println("Case post user");

		String name = "Pedro " + Global.DateNow();
		String job = "QA Engineer";

		RestAssured.baseURI = "https://reqres.in";

		String resPost = given().log().all().header("Content-Type", "application/json")
				.body(Payloads.AddUser(name, job)).when().post("api/users").then().log().all().assertThat()
				.statusCode(201).header("Server", "cloudflare").extract().response().asString();

		JsonPath js = Global.RawToJson(resPost);
		String nameRes = js.getString("name");
		String jobRes = js.getString("job");
		boolean idRes = js.getString("id") != null;
		boolean dateRes = js.getString("createdAt") != null;

		Assert.assertEquals(name, nameRes);
		Assert.assertEquals(job, jobRes);
		Assert.assertTrue(idRes);
		Assert.assertTrue(dateRes);
		
		System.out.println("Case post user with null  object");

		String nameN = "";
		String jobN = "";

		RestAssured.baseURI = "https://reqres.in";

		String resPostN = given().log().all().header("Content-Type", "application/json")
				.body(Payloads.AddUserNull(nameN, jobN)).when().post("api/users").then().log().all().assertThat()
				.statusCode(400).header("Server", "cloudflare").extract().response().asString();
		
		Assert.assertTrue(resPostN.contains("Bad Request"));

		System.out.println("Case get list user page 1");

		int page = 1;
		int perPage = 6;
		String url = "https://reqres.in/#support-heading";
		String text = "To keep ReqRes free, contributions towards server costs are appreciated!";

		String resGet1 = given().log().all().queryParam("page", "1").when().get("api/users").then().log().all()
				.assertThat().statusCode(200).header("Server", "cloudflare").extract().response().asString();

		JsonPath js1 = Global.RawToJson(resGet1);
		int pageRes = js1.getInt("page");
		int perPageRes = js1.getInt("per_page");
		boolean totalResB = js1.getString("total") != null;
		int totalRes = js1.getInt("total");
		int totalPagesRes = js1.getInt("total_pages");
		String urlRes = js1.getString("support.url");
		String textRes = js1.getString("support.text");
		int idResG = js1.getList("data.id").size();
		int emailRes = js1.getList("data.email").size();
		int firstNameRes = js1.getList("data.first_name").size();
		int lastNameRes = js1.getList("data.last_name").size();
		int avatarRes = js1.getList("data.avatar").size();

		int totalPages = totalRes / perPage;

		Assert.assertEquals(page, pageRes);
		Assert.assertEquals(perPage, perPageRes);
		Assert.assertTrue(totalResB);
		Assert.assertEquals(totalPages, totalPagesRes);
		Assert.assertEquals(url, urlRes);
		Assert.assertEquals(text, textRes);
		Assert.assertEquals(idResG, perPage);
		Assert.assertEquals(emailRes, perPage);
		Assert.assertEquals(firstNameRes, perPage);
		Assert.assertEquals(lastNameRes, perPage);
		Assert.assertEquals(avatarRes, perPage);
		
		System.out.println("Case get list user page 2");
		
		int page2 = 2;

		String resGet2 = given().log().all().queryParam("page", "2").when().get("api/users").then().log().all()
				.assertThat().statusCode(200).header("Server", "cloudflare").extract().response().asString();

		JsonPath js2 = Global.RawToJson(resGet2);
		int pageRes2 = js2.getInt("page");
		int perPageRes2 = js2.getInt("per_page");
		boolean totalResB2 = js2.getString("total") != null;
		int totalRes2 = js2.getInt("total");
		int totalPagesRes2 = js2.getInt("total_pages");
		String urlRes2 = js2.getString("support.url");
		String textRes2 = js2.getString("support.text");
		int idResG2 = js2.getList("data.id").size();
		int emailRes2 = js2.getList("data.email").size();
		int firstNameRes2 = js2.getList("data.first_name").size();
		int lastNameRes2 = js2.getList("data.last_name").size();
		int avatarRes2 = js2.getList("data.avatar").size();

		int totalPages2 = totalRes2 / perPage;

		Assert.assertEquals(page2, pageRes2);
		Assert.assertEquals(perPage, perPageRes2);
		Assert.assertTrue(totalResB2);
		Assert.assertEquals(totalPages2, totalPagesRes2);
		Assert.assertEquals(url, urlRes2);
		Assert.assertEquals(text, textRes2);
		Assert.assertEquals(idResG2, perPage);
		Assert.assertEquals(emailRes2, perPage);
		Assert.assertEquals(firstNameRes2, perPage);
		Assert.assertEquals(lastNameRes2, perPage);
		Assert.assertEquals(avatarRes2, perPage);

	}

}
