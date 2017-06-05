package rgr.ex;

public class DoStuff {
	
	java.util.HashMap<String, rgr.ent.RETSImage> rets_images;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoStuff ds = new DoStuff();
		ds.updateRetsImages();
	}

	
	public void updateRetsImages(){
		StringBuilder sb = new StringBuilder(); 
		sb.append("UPDATE flat_image SET pid= para_listing.pid ");
		sb.append("FROM para_listing, listing ");
		sb.append("WHERE flat_image.l_listingid = listing.l_listingid  and ");
		sb.append("para_listing.mls=listing.l_displayid and flat_image.pid in ('')");
		
		rgr.util.PostgresConnector.doUpdate(sb.toString());
	}
	
}
