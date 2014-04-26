package beerman.scheduler;

import java.util.List;

import org.apache.axis2.clustering.Member;
import org.apache.synapse.MessageContext;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.algorithms.AlgorithmContext;
import org.apache.synapse.endpoints.algorithms.LoadbalanceAlgorithm;

public class BeermanScheduler implements LoadbalanceAlgorithm {
	
	private List endpoints = null;
	
	private List<Member> members;
	
	public BeermanScheduler() {
		
	}
	
	public BeermanScheduler(List endpoints) {
		this.endpoints = endpoints;
	}

	@Override
	public void setApplicationMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	@Override
	public void setLoadBalanceEndpoint(Endpoint endpoint) {
		// Nothing to do here
	}

	@Override
	public Endpoint getNextEndpoint(MessageContext synapseMessageContext,
			AlgorithmContext algorithmContext) {
		return (Endpoint) this.endpoints.get(0);
	}

	@Override
	public Member getNextApplicationMember(AlgorithmContext algorithmContext) {
		return (Member) this.members.get(0);
	}

	@Override
	public void reset(AlgorithmContext algorithmContext) {
		// Nothing to do here
	}

	@Override
	public String getName() {
		return "BeermanScheduler";
	}

	public LoadbalanceAlgorithm clone() { return new BeermanScheduler(); }

}
