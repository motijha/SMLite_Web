package com.cisco.assignment.vendor.servlet;


/**
 * The servlet that manages the application's all RESTful service providers.
 * 
 * 
 */
public class VendorRESTfulServlet { //extends DirectServlet {

	private static final long serialVersionUID = -1L;

	/*private transient EntityBrokerCoreServiceManager entityBrokerCoreServiceManager;
	private transient EntityBrokerRESTServiceManager entityRESTServiceManager;

	private transient List<AbstractAutoRegisteringProvider> entityProviders;

	*//**
	 * Starts up all the entity providers and places them into the list
	 * 
	 * @param entityProviderManager
	 *            the provider manager
	 *//*
	protected void startProviders(EntityProviderManager entityProviderManager) {
		this.entityProviders = new ArrayList<AbstractAutoRegisteringProvider>();
		this.entityProviders
				.add(new VendorEntityProvider(entityProviderManager));
	}

	@Override
	public EntityRequestHandler initializeEntityRequestHandler() {
		EntityRequestHandler erh;
		try {
			// Creating connection to the DB and initializing the helper object.
			DBHelper.getInstance().init();

			// fire up the EB services
			this.entityBrokerCoreServiceManager = new EntityBrokerCoreServiceManager();
			EntityBrokerManager ebm = this.entityBrokerCoreServiceManager
					.getEntityBrokerManager();
			// create the EB REST services
			this.entityRESTServiceManager = new EntityBrokerRESTServiceManager(
					ebm);
			erh = this.entityRESTServiceManager.getEntityRequestHandler();
			if (erh == null) {
				throw new RuntimeException(
						"FAILED to load EB EntityRequestHandler");
			}

			EntityProviderManager epm = this.entityBrokerCoreServiceManager
					.getEntityProviderManager();
			// fire up the providers
			startProviders(epm);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(
					"FAILURE during init of direct servlet: " + e, e);
		}
		return erh;
	}

	@Override
	public void destroy() {
		super.destroy();
		DBHelper.getInstance().deInit();
		if (this.entityProviders != null) {
			for (AbstractAutoRegisteringProvider provider : entityProviders) {
				if (provider != null) {
					try {
						provider.destroy();
					} catch (Exception e) {
						System.err.println("WARN Could not clean up provider ("
								+ provider + ") on destroy: " + e);
					}
				}
			}
			this.entityProviders.clear();
			this.entityProviders = null;
		}
		if (this.entityRESTServiceManager != null) {
			this.entityRESTServiceManager.destroy();
			this.entityRESTServiceManager = null;
		}
		if (this.entityBrokerCoreServiceManager != null) {
			this.entityBrokerCoreServiceManager.destroy();
			this.entityBrokerCoreServiceManager = null;
		}
	}

	@Override
	public String getCurrentLoggedInUserId() {
		return "vendorUser";
	}

	@Override
	public void handleUserLogin(HttpServletRequest req,
			HttpServletResponse res, String path) {
		throw new SecurityException("Not able to handle login redirects yet");
	}
*/
}
